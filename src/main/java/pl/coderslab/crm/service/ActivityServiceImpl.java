package pl.coderslab.crm.service;

import org.springframework.stereotype.Service;
import pl.coderslab.crm.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;

    }
}
