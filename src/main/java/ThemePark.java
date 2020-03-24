import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    private String name;
    ArrayList<Attraction> attractions;
    ArrayList<Stall> stalls;

    public ThemePark(String name){
        this.name = name;
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }

    public void addStall(Stall stall){
        this.stalls.add(stall);
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> allIReviewed = new ArrayList<>();
        allIReviewed.addAll(attractions);
        allIReviewed.addAll(stalls);
        return allIReviewed;
    }

    public void visit(Visitor visitor, Attraction attraction){
        visitor.addAttraction(attraction);
        attraction.increaseVistCount();
    }

    public HashMap<String, Integer> reviews(){
        HashMap<String, Integer> reviews = new HashMap<>();
        for (IReviewed review : getAllReviewed()){
            reviews.put(review.getName(), review.getRating());
        }
        return reviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allowedReviewed = new ArrayList<>();
        for (IReviewed review : getAllReviewed()) {
            if (review instanceof ISecurity) {
                if (((ISecurity) review).isAllowedTo(visitor)) {
                    allowedReviewed.add(review);
                }
            } else {
                allowedReviewed.add(review);
            }
        }
        return allowedReviewed;
    }

    public String getName() {
        return name;
    }

    public int getAttractions() {
        return attractions.size();
    }

    public int getStalls() {
        return stalls.size();
    }
}
