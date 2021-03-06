package tw.edu.ncu.cc.activity.server.repository;

import tw.edu.ncu.cc.activity.server.entity.ActivityEntity;

import java.util.Date;
import java.util.List;

public interface ActivityRepository {
    public List<ActivityEntity> getLatestActivities( Date startDate, int limit );
}
