package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TripServiceTest {


    private TripService tripService;
    private User user;
    private UserSession userSession;
    private User loggedUser;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.addTrip(new Trip());

        loggedUser = new User();
        tripService = new TripService() {
            @Override
            protected List<Trip> getTrips(User user) {
                return user.trips();
            }
        };

    }


    @Test
    public void should_find_trips_when_users_are_friends() {
        // GIVEN
        user.addFriend(loggedUser);

        // WHEN
        List<Trip> tripsByUser = tripService.getTripsByFriend(loggedUser, user);

        // THEN
        assertThat(tripsByUser).hasSize(1);
    }

    @Test
    public void should_not_find_trips_when_users_are_not_friends() {
        // WHEN
        List<Trip> tripsByUser = tripService.getTripsByFriend(loggedUser, user);

        // THEN
        assertThat(tripsByUser).hasSize(0);
    }

    @Test(expected = UserNotLoggedInException.class)
    public void should_throw_user_not_logged_in() {
        tripService.getTripsByFriend(null, user);
    }
}
