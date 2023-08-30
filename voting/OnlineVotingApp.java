package com.voting;

import java.util.*;

class Voter {
	private int id;
	private String username;
	private String password;
	private boolean hasVoted;
	public Voter(int id, String username, String password, boolean hasVoted) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.hasVoted = hasVoted;
	}
	public Voter(int i, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isHasVoted() {
		return hasVoted;
	}
	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}

}

class Candidate {
	private int id;
	private String name;
	private int votes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public Candidate(int id, String name, int votes) {
		super();
		this.id = id;
		this.name = name;
		this.votes = votes;
	}

	public Candidate(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public void incrementVotes() {
		votes++;
	}
}

class Ballot {
	private int id;
	private String title;
	private List<Candidate> candidates;
	private boolean isOpen;

	public Ballot(int id, String title, List<Candidate> candidates, boolean isOpen) {
		super();
		this.id = id;
		this.title = title;
		this.candidates = candidates;
		this.isOpen = isOpen;
	}

	public Ballot(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public void addCandidate(Candidate candidate) {
		candidates.add(candidate);
	}
}

class Election {
	private int id;
	private String name;
	private List<Ballot> ballots;
	private boolean isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ballot> getBallots() {
		return ballots;
	}

	public void setBallots(List<Ballot> ballots) {
		this.ballots = ballots;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Election(int id, String name, List<Ballot> ballots, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.ballots = ballots;
		this.isActive = isActive;
	}

	public Election(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public void addBallot(Ballot ballot) {
		ballots.add(ballot);
	}
}

class VotingSystem {
	private List<Voter> voters;
	private List<Election> elections;

	public VotingSystem(List<Voter> voters, List<Election> elections) {
		super();
		this.voters = voters;
		this.elections = elections;
	}

	public VotingSystem() {
		// TODO Auto-generated constructor stub
	}

	public List<Voter> getVoters() {
		return voters;
	}

	public void setVoters(List<Voter> voters) {
		this.voters = voters;
	}

	public List<Election> getElections() {
		return elections;
	}

	public void setElections(List<Election> elections) {
		this.elections = elections;
	}

	public void registerVoter(Voter voter) {
		voters.add(voter);
		this.voters=voters;
	}

	public void createElection(Election election) {
		elections.add(election);
		this.elections=elections;
	}

	public void openBallot(Ballot ballot) {
		ballot.setOpen(true);
	}

	public void closeBallot(Ballot ballot) {
		ballot.setOpen(false);
	}

	public void castVote(Voter voter, Ballot ballot, Candidate candidate) {
		if (voter.isHasVoted() || !ballot.isOpen()) {
			// Handle error, voter has already voted or the ballot is closed
			return;
		}
		candidate.incrementVotes();
		voter.setHasVoted(true);
	}

	public void generateResults(Election election) {
	    List<Ballot> ballots = election.getBallots();

	    for (Ballot ballot : ballots) {
	        if (!ballot.isOpen()) {
	            System.out.println("Results for Ballot: " + ballot.getTitle());
	            List<Candidate> candidates = ballot.getCandidates();
	            Candidate winner = null;
	            int maxVotes = -1;

	            for (Candidate candidate : candidates) {
	                System.out.println(candidate.getName() + " - Votes: " + candidate.getVotes());
	                if (candidate.getVotes() > maxVotes) {
	                    maxVotes = candidate.getVotes();
	                    winner = candidate;
	                }
	            }

	            if (winner != null) {
	                System.out.println("Winner: " + winner.getName());
	            } else {
	                System.out.println("No winner for this ballot.");
	            }

	            System.out.println();
	        }
	    }
	}

}

public class OnlineVotingApp {
	public static void main(String[] args) {

		VotingSystem votingSystem = new VotingSystem(new ArrayList<>(), new ArrayList<>());

        // Create and add voters, candidates, ballots, and elections
        Voter voter1 = new Voter(1, "voter1", "password1", false); // Add missing argument 'false'
        Candidate candidate1 = new Candidate(1, "Candidate A", 0); // Initialize votes to 0
        Candidate candidate2 = new Candidate(2, "Candidate B", 0); // Initialize votes to 0
        Ballot ballot1 = new Ballot(1, "Ballot 1", new ArrayList<>(), false); // Add missing arguments
        Election election1 = new Election(1, "Election 1", new ArrayList<>(), true); // Add missing arguments

        votingSystem.registerVoter(voter1);
        votingSystem.createElection(election1);
        election1.addBallot(ballot1);
        ballot1.addCandidate(candidate1);
        ballot1.addCandidate(candidate2);

        // Sample interactions
        votingSystem.openBallot(ballot1);
        votingSystem.castVote(voter1, ballot1, candidate1);
        votingSystem.closeBallot(ballot1);
        votingSystem.generateResults(election1);
	}
}