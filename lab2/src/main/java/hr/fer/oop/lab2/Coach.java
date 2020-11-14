package hr.fer.oop.lab2;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.ManageableTeam;
import hr.fer.oop.lab2.welcomepack.Manager;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;

public class Coach extends Person implements Manager{
	private int coachingSkill = Constants.DEFAULT_COACHING_SKILL;
	private Formation formation = Constants.DEFAULT_FORMATION;
	private ManageableTeam managingTeam;
	
	/**
	 * Constructor that sets the coaches name, country, emotion, his coaching skill, and his formation
	 * @param name
	 * @param country
	 * @param emotion
	 * @param coachingSkill
	 * @param formation
	 * @author Fran Vlahović
	 */
	public Coach(String name, String country, int emotion, int coachingSkill, Formation formation) {
		super(name, country, emotion);
		setCoachingSkill(coachingSkill);
		setFormation(formation);
	}
	

	public Coach() {
		super();
	}

	/**
	 * Method that sets the coaching skill to the specified value if the said value if the value is within the boundaries
	 * @param coachingSkill
	 * @author Fran Vlahović
	 */
	public void setCoachingSkill(int coachingSkill) {
		if(coachingSkill>=Constants.MIN_COACHING_SKILL && coachingSkill<=Constants.MAX_COACHING_SKILL)
			this.coachingSkill = coachingSkill;
		else System.err.println("Trenerova vjestina je izvan trazenog raspona");
	}
	
	/**
	 * Method that sets the formation to the specified value if the said value if the value is within the boundaries
	 * @param formation
	 * @author Fran Vlahović
	 */
	public void setFormation(Formation formation) {
		if(formation!=null)
			this.formation = formation;
		else System.err.println("Formacija ne smije biti null");
	}
	
	/**
	 * Gets the coaching skill of a coach
	 * @return coachingSkill
	 * @author Fran Vlahović
	 */
	public int getCoachingSkill() {
		return coachingSkill;
	}


	/**
	 * Gets the formation of a team
	 * @return formation
	 * @author Fran Vlahović
	 */
	public Formation getFormation() {
		return formation;
	}

	/**
	 * Picks the starting eleven players among registered players of the team
	 * @author Fran Vlahović
	 */
	@Override
	public void pickStartingEleven() {
		int gk = this.managingTeam.getFormation().getNoGK();
		int df = this.managingTeam.getFormation().getNoDF();
        int mf = this.managingTeam.getFormation().getNoMF();
        int fw = this.managingTeam.getFormation().getNoFW();
        
        this.managingTeam.clearStartingEleven();
        
        for(FootballPlayer p1 : this.managingTeam.getRegisteredPlayers().getPlayers()) {
        	if(p1!=null && this.managingTeam.getRegisteredPlayers().size()!=this.managingTeam.getRegisteredPlayers().getMaxSize()) {
        		if(p1.getPlayingPosition()==PlayingPosition.DF) {
        			if(df>0) {
        				this.managingTeam.addPlayerToStartingEleven(p1);
        				df--;
        			}
        		}
        		
        		if(p1.getPlayingPosition()==PlayingPosition.FW) {
        			if(fw>0) {
        				this.managingTeam.addPlayerToStartingEleven(p1);
        				fw--;
        			}
        		}
        		
        		if(p1.getPlayingPosition()==PlayingPosition.GK) {
        			if(gk>0) {
        				this.managingTeam.addPlayerToStartingEleven(p1);
        				gk--;
        			}
        		}
        		
        		if(p1.getPlayingPosition()==PlayingPosition.MF) {
        			if(mf>0) {
        				this.managingTeam.addPlayerToStartingEleven(p1);
        				mf--;
        			}
        		}
        		
//        		switch(p1.getPlayingPosition()) {
//        		case DF:
//        			if(df>0) {
//        				managingTeam.addPlayerToStartingEleven(p1);
//        				df--;
//        			}
//        			break;
//        		case FW:
//        			if(fw>0) {
//        				managingTeam.addPlayerToStartingEleven(p1);
//        				fw--;
//        			}
//        			break;
//        		case GK:
//        			if(gk>0) {
//        				managingTeam.addPlayerToStartingEleven(p1);
//        				gk--;
//        			}
//        			break;
//        		case MF:
//        			if(mf>0) {
//        				managingTeam.addPlayerToStartingEleven(p1);
//        				mf--;
//        			}
//        			break;
//        		default:
//        			break;
//        		}
        	}
        }
	}

	/**
	 * Forces the coaches specified formation
	 * @author Fran Vlahović
	 */
	@Override
	public void forceMyFormation() {
		this.managingTeam.setFormation(this.formation);
	}

	/**
	 * Manager sets a team that he manages if the team is not null
	 * @param team
	 * @author Fran Vlahović
	 */
	@Override
	public void setManagingTeam(ManageableTeam team) {
		if(team!=null)
			this.managingTeam=team;
		else System.err.println("Tim ne smije biti null");
	}
}