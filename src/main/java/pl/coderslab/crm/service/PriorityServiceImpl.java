package pl.coderslab.crm.service;

import org.springframework.stereotype.Service;
import pl.coderslab.crm.repository.PriorityRepository;

@Service
public class PriorityServiceImpl implements PriorityService {
    private final PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;

    }
}
