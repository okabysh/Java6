package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_SortedSet_Mappings;

import java.util.Comparator;

/**
 * Created by Oleg Kabysh on 30.07.2017.
 */
public class MyClass implements Comparator<Certificate_SSM> {
    public int compare(Certificate_SSM o1, Certificate_SSM o2) {
        final int BEFORE = -1;
        final int AFTER = 1;
/* To reverse the sorting order, multiple by -1 */
        if (o2 == null) {
            return BEFORE * -1;
        }
        Comparable thisCertificate = o1.getName();
        Comparable thatCertificate = o2.getName();
        if (thisCertificate == null) {
            return AFTER * 1;
        } else if (thatCertificate == null) {
            return BEFORE * -1;
        } else {
            return thisCertificate.compareTo(thatCertificate) * -1;
        }
    }
}
