package com.shepard.oauth.service;

import com.shepard.oauth.repository.ManagerPasswordRepository;
import com.shepard.oauth.util.CollectionExt;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.singletonList;

@Service
public class AccountDetailsService implements UserDetailsService, CollectionExt {

    @Autowired
    private ManagerPasswordRepository managerPasswordRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        val hash = managerPasswordRepository.findByUsername(username);
        if (hash == null || hash.isEmpty())
            throw new UsernameNotFoundException("Manager with login [" + username + "] not found");

        return new User(username, single(hash).getHash(), true, true, true,
                true, singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
