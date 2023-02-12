package showme.services;

import showme.models.api.spending.SpendingGetTypeResponse;

public interface SpendingService {

    SpendingGetTypeResponse getType(String userId);
}
