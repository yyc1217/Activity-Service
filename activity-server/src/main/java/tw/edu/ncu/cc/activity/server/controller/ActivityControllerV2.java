package tw.edu.ncu.cc.activity.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ncu.cc.activity.data.v1.Activity;
import tw.edu.ncu.cc.activity.server.service.ActivityService;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping( method = RequestMethod.GET )
public class ActivityControllerV2 {

    private ActivityService activityService;

    @Autowired
    public void setActivityService( ActivityService activityService ) {
        this.activityService = activityService;
    }

    @RequestMapping( value = "v2/activity" )
    public List<Activity> getActivities( @RequestParam( "size" ) Integer size ) {
        return activityService.getLatestActivities( new Date(), ( size > 0 && size <= 40 ? size : 20 ) );
    }

}
