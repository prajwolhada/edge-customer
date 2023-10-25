package utilities;

import com.flsoft.bankxp.edge.entities.model.ApplicationUser;
import com.flsoft.bankxp.edge.entities.model.Branch;
import com.flsoft.bankxp.edge.entities.model.District;
import com.flsoft.bankxp.edge.entities.model.Province;

import java.util.Date;

public class BranchMockUtil {

    public static Branch mockBranch() {
        Branch branch = new Branch();

        branch.setId(0L);
        branch.setBranchCode("001");
        branch.setBranchName("Pulchowk Branch");
        branch.setBranchLocation("Pulchowk Lalitpur");
        branch.setActive('Y');
        branch.setCreatedBy(new ApplicationUser());
        branch.setCreatedDate(new Date());
        branch.setModifiedBy(new ApplicationUser());
        branch.setModifiedDate(new Date());
        branch.setLatitude("27.6782");
        branch.setLongitude("85.3169");
        branch.setContactNo("01-54284942");
        branch.setIpsBranchCode("001");
        branch.setCheckTxnAlert('Y');
        branch.setProvince(new Province());
        branch.setProvinceId(1L);
        branch.setDistrict(new District());
        branch.setDistrictId(1L);
        branch.setEmail("");
        branch.setAllowQuickAccount('Y');

        return branch;
    }
}
