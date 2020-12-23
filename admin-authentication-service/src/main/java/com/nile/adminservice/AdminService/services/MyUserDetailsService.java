package com.nile.adminservice.AdminService.services;

import com.nile.adminservice.AdminService.models.Admin;
import com.nile.adminservice.AdminService.models.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Admin> admin = adminRepository.findByUsername(userName);

        admin.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return admin.map(MyUserDetails::new).get();
    }
}
