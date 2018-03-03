package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;

import java.util.Collections;
import java.util.List;

public class TripService {

	public List<Trip> getTripsByFriend(User loggedUser, User friend) throws UserNotLoggedInException {
		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}

		if (friend.isFriend(loggedUser)) {
			return getTrips(friend);
		} else {
			return Collections.emptyList();
		}

	}

	protected List<Trip> getTrips(User user) {
		return TripDAO.findTripsByUser(user);
	}

}
