package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();


        /* TO DO 1: Retourner une chaine de caractère qui contient tous les noms des enseignants en majuscule separés par # */
        /* TO DO 1  hint(reduce)*/
        String names = teachers.stream().map(teacher -> teacher.getName().toUpperCase()).reduce("names: ",(teacher1, teacher2) -> teacher1 + "#" +  teacher2);

        /* TO DO 2: Retourner une set d'enseignants Java dont le salaire > 80000 */
        Set<Teacher> teachers1 = teachers.stream().filter(teacher -> teacher.getSalary() > 80000).filter(teacher -> teacher.getSubject().equals(Subject.JAVA)).collect(Collectors.toSet());

        /* TO DO 3: Retourner une TreeSet d'enseignants (tri par nom et en cas d'égalité tri par salaire) */
        TreeSet<Teacher> teachers2 = teachers.stream().collect(Collectors.toCollection(() ->new TreeSet<>(Comparator.comparing(Teacher::getName).thenComparing(Teacher::getSalary))));
        /* TO DO 4: Retourner une Map qui regroupe les enseignants par module */
        Map<Subject, List<Teacher>> map = teachers.stream().collect(Collectors.groupingBy(teacher -> teacher.getSubject()));

        /* TO DO 5: Retourner une Map qui regroupe les nom des enseignants par salaire */
        Map<Integer, String> map2 = teachers.stream().collect(Collectors.toMap(teacher -> teacher.getSalary(),teacher -> teacher.getName(),(t1,t2) -> t1+"#"+t2));
        /* TO DO 6: Afficher les nom des enseignants de chaque module */

    }
}
