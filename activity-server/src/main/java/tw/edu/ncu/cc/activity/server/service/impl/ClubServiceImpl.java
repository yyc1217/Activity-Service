package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import tw.edu.ncu.cc.activity.data.v1.Club;
import tw.edu.ncu.cc.activity.server.entity.ClubEntity;
import tw.edu.ncu.cc.activity.server.repository.ClubRepository;
import tw.edu.ncu.cc.activity.server.service.ClubService;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository    clubRepository;
    private ConversionService conversionService;

    @Autowired
    public void setClubRepository( ClubRepository clubRepository ) {
        this.clubRepository = clubRepository;
    }

    @Autowired
    public void setConversionService( ConversionService conversionService ) {
        this.conversionService = conversionService;
    }

    @Override
    @SuppressWarnings( "unchecked" )
    @Cacheable( value = "production", key = "'clubsAll'" )
    public List<Club> getAllClubs() {
        return ( List<Club> ) conversionService.convert(
                clubRepository.getAllClubs(),
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( ClubEntity.class ) ),
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( Club.class ) )
        );
    }



}
