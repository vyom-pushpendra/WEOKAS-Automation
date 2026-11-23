
package vYomUtilities;

import java.util.Random;
import java.util.UUID;

public class RandomDataUtility {

    static Random random = new Random();

    // 1. Random Full Name
//    public static String getRandomName() {
//
//        return "Member" + random.nextInt(100000);
//    }
    
    public static String getRandomName() {

        String characters = "abcdefghijklmnopqrstuvwxyz";

        Random random = new Random();

        StringBuilder name = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            name.append(characters.charAt(random.nextInt(characters.length())));
        }

        return name.toString();
    }

    // 2. Random Email Address
    public static String getRandomEmail() {

        return "member"
                + UUID.randomUUID().toString().substring(0, 8)
                + "@gmail.com";
    }

    // 3. Random Phone Number (10 Digit)
    public static String getRandomMobile() {

        return "9" + (100000000 + random.nextInt(900000000));
    }

    // 4. Random Date Of Birth
    public static String getRandomDOB() {

        int day = 1 + random.nextInt(28);
        int month = 1 + random.nextInt(12);
        int year = 1985 + random.nextInt(15);

        return String.format("%02d/%02d/%d",
                day, month, year);
    }

    // 5. Random Blood Group
    public static String getRandomBloodGroup() {

        String[] bloodGroups = {
                "A+", "A-", "B+", "B-",
                "AB+", "AB-", "O+", "O-"
        };

        return bloodGroups[
                random.nextInt(bloodGroups.length)];
    }

    // 6. Random Role
    public static String getRandomRole() {

        String[] roles = {
                "super_admin",
                "programmer",
                "si_admin",
                "distributor_admin"
        };

        return roles[
                random.nextInt(roles.length)];
    }

    // 7. Random Company Name
    public static String getRandomCompany() {

        return "Company" + random.nextInt(100000);
    }

    // 8. Random Address
    public static String getRandomAddress() {

        return "Sector " + random.nextInt(100)
                + ", Gurgaon, Haryana";
    }
    
    //Random Role Name
    
 // Random Role Name
    public static String getRandomRoleName() {

        return "Testing" +
                UUID.randomUUID().toString().substring(0, 8);
    }
    
    
}
