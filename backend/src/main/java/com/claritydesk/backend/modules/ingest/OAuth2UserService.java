package com.claritydesk.backend.modules.ingest;

import com.claritydesk.backend.domain.entities.User;
import com.claritydesk.backend.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String googleId    = oAuth2User.getAttribute("sub");
        String email       = oAuth2User.getAttribute("email");
        String name        = oAuth2User.getAttribute("name");
        String picture     = oAuth2User.getAttribute("picture");
        String accessToken = userRequest.getAccessToken().getTokenValue();

        userRepository.findByGoogleId(googleId).ifPresentOrElse(
            existing -> {
                existing.setGoogleAccessToken(accessToken);
                existing.setName(name);
                existing.setProfilePictureUrl(picture);
                userRepository.save(existing);
                log.info("Updated existing user: {}", email);
            },
            () -> {
                User newUser = User.builder()
                        .googleId(googleId)
                        .email(email)
                        .name(name)
                        .profilePictureUrl(picture)
                        .googleAccessToken(accessToken)
                        .build();
                userRepository.save(newUser);
                log.info("Created new user: {}", email);
            }
        );

        return oAuth2User;
    }
}
