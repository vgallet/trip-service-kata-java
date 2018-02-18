Testing legacy code: Hard-wired dependencies
============================================

What is it about?
-----------------

Provides an example of existing code that needs to be unit tested. But there is one rule:

> We can't change any existing code if not covered by tests. The only exception is if we need to change the code to add unit tests, but in this case, just automated refactorings (via IDE) are allowed. 

Although this is a very small piece of code, it has a lot of the problems that we find in legacy code. 

Details
-------

If you want to give it a go, the starting point is TripServiceTest.java and TripService.java. Try unit testing it following the rule above.

For future comparisions, when you are done, you can always check TripService_Original.java