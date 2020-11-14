package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;
import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

public class SearchUtil {
	
	public static SimpleFootballPlayerCollection retrieveAboveMedianSkillPlayers(SimpleFootballPlayerCollection players) {
		SimpleFootballPlayerCollection aboveAverage=new SimpleFootballPlayerCollectionImpl(players.size());
		double average= ((double) players.calculateSkillSum()) / players.size();
		 FootballPlayer[] player = players.getPlayers();
		 
		 for(int i=0;i<players.size();i++) {
				if(player[i].getPlayingSkill()>average) {
					aboveAverage.add(player[i]);
				}
			}
			return aboveAverage;
	}
	
	public static FootballPlayer retrieveLowSkilledPlayer(SimpleFootballPlayerCollection players, PlayingPosition playingPos) {
		FootballPlayer lowestSkilledPlayer=null;
		FootballPlayer[] player=players.getPlayers();
		int lowestSkill=player[0].getPlayingSkill();
		if(players.size()==0)
			return null;
		for(int i=0; i<players.size(); ++i) {
			if(player[i].getPlayingPosition()==playingPos && player[i].getPlayingSkill()<=lowestSkill) {
				lowestSkilledPlayer=player[i];
				lowestSkill=player[i].getPlayingSkill();
			}
		}
		return lowestSkilledPlayer;
	}
	
	public static SimpleFootballPlayerCollection retrievePlayingPositionPlayers(SimpleFootballPlayerCollection players, PlayingPosition playingPos) {
		SimpleFootballPlayerCollection playersPosition=new SimpleFootballPlayerCollectionImpl(players.size());
		FootballPlayer[] player = players.getPlayers();
		for(int i=0; i<players.size(); ++i) {
			if(player[i].getPlayingPosition()==playingPos)
				playersPosition.add(player[i]);
		}
		return playersPosition;
	}
	
	public static void main(String[] args) {
		SimpleFootballPlayerCollection collection=new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_CLUB);
		FootballPlayer player1=new FootballPlayer("ivo", "hrvatska", 30, 50, PlayingPosition.GK);
		FootballPlayer player2=new FootballPlayer("mate", "hrvatska", 13, 54, PlayingPosition.FW);
		FootballPlayer player3=new FootballPlayer("jura", "hrvatska", 40, 23, PlayingPosition.FW);
		FootballPlayer player4=new FootballPlayer("simun", "hrvatska", 20, 100, PlayingPosition.DF);
		FootballPlayer player5=new FootballPlayer("fran", "hrvatska", 70, 75, PlayingPosition.MF);
		collection.add(player1);
		collection.add(player2);
		collection.add(player3);
		collection.add(player4);
		collection.add(player5);
		
		SimpleFootballPlayerCollection aboveMedian=new SimpleFootballPlayerCollectionImpl(collection.size());
		aboveMedian=retrieveAboveMedianSkillPlayers(collection);
		for(FootballPlayer p : aboveMedian.getPlayers()){
			if(p!=null)
				System.out.println(p.getName() + " " + p.getPlayingSkill());
		}
		
		System.out.println();
		
		FootballPlayer lowestSkilled=new FootballPlayer();
		lowestSkilled=retrieveLowSkilledPlayer(collection, PlayingPosition.FW);
		if(lowestSkilled==null)
			System.out.println("Nema igraca u kolekciji");
		else
			System.out.println(lowestSkilled.getName() + " " + lowestSkilled.getPlayingSkill());
		
		System.out.println();
		
		SimpleFootballPlayerCollection playingPosPlayers=new SimpleFootballPlayerCollectionImpl(collection.size());
		playingPosPlayers=retrievePlayingPositionPlayers(collection, PlayingPosition.FW);
		for(FootballPlayer p : playingPosPlayers.getPlayers()){
			if(p!=null)
				System.out.println(p.getName() + " " + p.getPlayingSkill());
		}
	}
}