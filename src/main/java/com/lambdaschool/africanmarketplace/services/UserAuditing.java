package com.lambdaschool.africanmarketplace.services;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAuditing
    implements AuditorAware<String>
{
    /**
     * The current user
     *
     * @return Optional(String) of current user
     */
    @Override
    public Optional<String> getCurrentAuditor()
    {
        String uname;
        Authentication authentication = SecurityContextHolder.getContext()
            .getAuthentication();
        if (authentication != null)
        {
            uname = authentication.getName();
        } else
        {
            uname = "SYSTEM";
        }
        return Optional.of(uname);
    }
}