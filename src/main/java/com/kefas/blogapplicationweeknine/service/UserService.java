package com.kefas.blogapplicationweeknine.service;

import com.kefas.blogapplicationweeknine.model.User;
import com.kefas.blogapplicationweeknine.payload.*;
import com.kefas.blogapplicationweeknine.response.ApiResponse;

import java.nio.file.attribute.UserPrincipal;

public interface UserService {
    UserSummaryPayload getCurrentUser(UserPrincipal currentUser);
    User addUser(UserPayload user);
    User updateUser(User newUser, String email, UserPrincipal currentUser);
    UserIdentityAvailability checkEmailAvailability(String email);
    UserProfilePayload getUserProfile(String email);
    ApiResponse giveAdmin(String email);
    UserProfilePayload setOrUpdateInfo(UserPrincipal currentUser, InfoPayload infoRequest);
}
