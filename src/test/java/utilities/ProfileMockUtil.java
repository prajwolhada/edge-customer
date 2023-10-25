package utilities;

import com.flsoft.bankxp.edge.entities.model.*;

import java.util.ArrayList;
import java.util.Date;

public class ProfileMockUtil {

    public static Profile mockProfile() {
        Profile profile = new Profile();
        profile.setId(1L);
        profile.setProfileName("All Roles");
        profile.setCode("ALL_ROLES");
        profile.setProfileDescription("All Role");
        profile.setRemarks("");
        profile.setProfileType("");
        profile.setActive('Y');
        profile.setProfileAttributes(new ArrayList<ProfileAttribute>());
        profile.setProfileMainTxnLimitList(new ArrayList<ProfileMainTxnLimit>());
        profile.setProfileFeatures(new ArrayList<ProfileFeature>());
        profile.setProfileAccessibleChannelList(new ArrayList<ProfileAccessibleChannel>());
        profile.setProfileChargeList(new ArrayList<ProfileCharge>());
        profile.setCreatedBy(new ApplicationUser());
        profile.setCreatedDate(new Date());
        profile.setLastModifiedBy(new ApplicationUser());
        profile.setLastModifiedDate(new Date());

        return profile;
    }
}
