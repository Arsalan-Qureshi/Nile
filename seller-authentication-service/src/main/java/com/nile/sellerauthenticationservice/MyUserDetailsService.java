package com.nile.sellerauthenticationservice;

import com.nile.sellerauthenticationservice.models.MyUserDetails;
import com.nile.sellerauthenticationservice.models.Seller;
import com.nile.sellerauthenticationservice.models.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Seller> seller = sellerRepository.findByUserName(userName);

        seller.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return seller.map(MyUserDetails::new).get();
    }
}
