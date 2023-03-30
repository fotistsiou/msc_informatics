package unipi.iatriki_plhroforikh.fotis.mathima2_part1;

import org.springframework.data.repository.CrudRepository;

public interface DrugRepository extends CrudRepository<Drug,Integer> {
    Drug findByTradeMark(String Name);
}
