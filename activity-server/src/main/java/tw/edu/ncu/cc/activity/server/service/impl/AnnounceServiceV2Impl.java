package tw.edu.ncu.cc.activity.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import tw.edu.ncu.cc.activity.data.v2.Announce;
import tw.edu.ncu.cc.activity.server.entity.AnnounceEntity;
import tw.edu.ncu.cc.activity.server.repository.AnnounceRepository;
import tw.edu.ncu.cc.activity.server.service.AnnounceServiceV2;

import java.util.Date;
import java.util.List;

@Service
public class AnnounceServiceV2Impl implements AnnounceServiceV2 {

    private AnnounceRepository announceRepository;
    private ConversionService conversionService;

    @Autowired
    public void setAnnounceRepository( AnnounceRepository announceRepository ) {
        this.announceRepository = announceRepository;
    }

    @Autowired
    public void setConversionService( ConversionService conversionService ) {
        this.conversionService = conversionService;
    }

    @Override
    @Cacheable( value = "production", key = "'announcesCommonLatestV2:' + #limit" )
    public List< Announce > getLatestCommonAnnounces( Date dateNow, int limit ) {
        return getAnnounces( announceRepository.getLatestCommonAnnounces( dateNow, limit ) );
    }

    @Override
    @Cacheable( value = "production", key = "'announcesGroupLatestV2:' + #limit" )
    public List< Announce > getLatestGroupAnnounces( Date dateNow, int limit ) {
        return getAnnounces( announceRepository.getLatestGroupAnnounces( dateNow, limit ) );
    }

    @Override
    @Cacheable( value = "production", key = "'announcesCommonNewerV2:' + #limit + '/' + #id" )
    public List< Announce > getCommonAnnouncesNewerThan( int id, Date dateNow, int limit ) {
        return getAnnounces( announceRepository.getCommonAnnouncesNewerThan( id, dateNow, limit ) );
    }

    @Override
    @Cacheable( value = "production", key = "'announcesGroupNewerV2:' + #limit + '/' + #id" )
    public List< Announce > getGroupAnnouncesNewerThan( int id, Date dateNow, int limit ) {
        return getAnnounces( announceRepository.getGroupAnnouncesNewerThan( id, dateNow, limit ) );
    }

    @Override
    @Cacheable( value = "production", key = "'announcesCommonOlderV2:' + #limit + '/' + #id" )
    public List< Announce > getCommonAnnouncesOlderThan( int id, Date dateNow, int limit ) {
        return getAnnounces( announceRepository.getCommonAnnouncesOlderThan( id, dateNow, limit ) );
    }

    @Override
    @Cacheable( value = "production", key = "'announcesGroupOlderV2:' + #limit + '/' + #id" )
    public List< Announce > getGroupAnnouncesOlderThan( int id, Date dateNow, int limit ) {
        return getAnnounces( announceRepository.getGroupAnnouncesOlderThan( id, dateNow, limit ) );
    }

    @SuppressWarnings( "unchecked" )
    private List< Announce > getAnnounces( List<AnnounceEntity > announceEntities ) {
        return ( List< Announce > ) conversionService.convert(
                announceEntities,
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( AnnounceEntity.class ) ),
                TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( Announce.class ) )
        );
    }

}
