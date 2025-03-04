package teams_exercise;

import java.util.ArrayList;

public class Team {
    private String name;
    private String baseLocation;
    private String coachName;
    private ArrayList<Player> players;
    private Player captain;

    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    private boolean isPlayersEmpty(){
        return players.isEmpty();
    }

    private boolean isPlayersNull(){
        return players == null;
    }

    private boolean isPlayersFull(){
        return  players.size() == 18;
    }

    private boolean isPlayersValid(){
        return !isPlayersEmpty() && !isPlayersNull();
    }

    private boolean isPlayerInTeam(Player player){
        return players.contains(player);
    }

    public void addPlayer(Player player){
        //vale a pena manter a inicialização aqui ou no construtor?
        if(isPlayersNull()){
            this.players = new ArrayList<>();
        }

        if(isPlayerInTeam(player)){
            System.out.println("Player already in the team");
            return;
        }

        if(isPlayersFull()){
            System.out.println("Team is full");
            return;
        }

        players.add(player);
        player.setTeam(this);
    }

    public void removePlayer(Player player){
        if(!isPlayersValid()){
            System.out.println("No players in the team");
            return;
        }

        if(!isPlayerInTeam(player)){
            System.out.println("Player not found");
            return;
        }

        if(player == captain){
            captain = null;
        }

        player.setTeam(null);
        players.remove(player);
    }

    public void substitute(Player substitute, Player starter){
        if(!isPlayersValid()){
            System.out.println("No players in the team");
            return;
        }

        if(!isPlayerInTeam(substitute)) {
            System.out.println("Substitute player not found");
            return;
        }

        if(!isPlayerInTeam(starter)){
            System.out.println("Starter player not found");
            return;
        }

        substitute.setFielded(true);
        starter.setFielded(false);
    }

    public void setCaptain(Player captain){
        if(!isPlayersValid()){
            System.out.println("No players in the team");
            return;
        }

        if(!isPlayerInTeam(captain)){
            System.out.println("Captain not found");
            return;
        }

        this.captain = captain;
    }

    public ArrayList<Player> getFieldedPlayers() {
        return players.stream()
                .filter(Player::isFielded)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    public ArrayList<Player> getOutfieldedPlayers() {
        return players.stream()
                .filter(player -> !player.isFielded())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public String getStateAsString(){
        return '\n' + "Name: " + name + '\n' +
                "Base Location: " + baseLocation + '\n' +
                "Coach Name: " + coachName + '\n'
                + (captain != null ? "Captain: " + captain.getName() + '\n' : "");
    }

    public String getPlayersAsString(){
        return players.stream()
                .map(Player::getStateAsString)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}
