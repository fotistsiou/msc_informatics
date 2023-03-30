package unipi.iatriki_plhroforikh.fotis.mathima2_part1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tradeMark;
    private String activeIngredients;
    private String marketingManager;

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public String getActiveIngredients() {
        return activeIngredients;
    }

    public void setActiveIngredients(String activeIngredients) {
        this.activeIngredients = activeIngredients;
    }

    public String getMarketingManager() {
        return marketingManager;
    }

    public void setMarketingManager(String marketingManager) {
        this.marketingManager = marketingManager;
    }
}
