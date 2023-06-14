
package Model;


public class BizStudent extends Student{
    private double accountScore;
    private double marketScore;


    public BizStudent() {
    }

    public BizStudent(int id, String fullName, Address address, double accountScore, double marketScore) {
        super(id, fullName, address);
        this.accountScore = accountScore;
        this.marketScore = marketScore;

    }

    public double getAccountScore() {
        return accountScore;
    }

    public void setAccountScore(double accountScore) {
        this.accountScore = accountScore;
    }

    public double getMarketScore() {
        return marketScore;
    }

    public void setMarketScore(double marketScore) {
        this.marketScore = marketScore;
    }

    @Override
    public void CaculateAverageScore() {
        averageScore = (accountScore*2 + marketScore)/3;
        
    }
  
    
}
