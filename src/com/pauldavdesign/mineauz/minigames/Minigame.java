package com.pauldavdesign.mineauz.minigames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class Minigame {
	private String name = "GenericName";
	private String type = null;
	private boolean enabled = false;
	private int minPlayers = 2;
	private int maxPlayers = 4;
	private List<String> flags = new ArrayList<String>();
	private Location spleefFloor1 = null;
	private Location spleefFloor2 = null;
	private FloorDegenerator sfloordegen;
	private Material spleefFloorMaterial = Material.SNOW_BLOCK;
	private List<Location> startLocations = new ArrayList<Location>();
	private Location endPosition = null;
	private Location quitPosition = null;
	private Location lobbyPosisiton = null;
	private List<ItemStack> loadout = new ArrayList<ItemStack>();
	private Map<String, RestoreBlock> restoreBlocks = new HashMap<String, RestoreBlock>();
	private boolean betting = false;
	private String location = null;
	private int maxRadius = 1000;
	private int minTreasure = 0;
	private int maxTreasure = 8;
	private ItemStack rewardItem = null;
	private double rewardPrice = 0;
	private ItemStack secondaryRewardItem = null;
	private double secondaryRewardPrice = 0;
	private boolean usePermissions = false;
	
	//Teams
	private List<Player> redTeam = new ArrayList<Player>();
	private List<Player> blueTeam = new ArrayList<Player>();
	
	private int redTeamScore = 0;
	private int blueTeamScore = 0;
	
	private int minScore = 5;
	private int maxScore = 10;

	private List<Location> startLocationsBlue = new ArrayList<Location>();
	private List<Location> startLocationsRed = new ArrayList<Location>();
	
	//Unsaved data
	private List<Player> players = new ArrayList<Player>();
	//Multiplayer
	private MultiplayerTimer mpTimer = null;
	private MultiplayerBets mpBets = null;
	//TreasureHunt
	private TreasureHuntTimer thTimer = null;

	public Minigame(String name, String type, Location start){
		this.name = name;
		this.type = type;
		startLocations.add(start);
	}
	
	public Minigame(String name){
		this.name = name;
	}
	
	public void setSecondaryRewardItem(ItemStack secondaryRewardItem){
		this.secondaryRewardItem = secondaryRewardItem;
	}

	public ItemStack getSecondaryRewardItem(){
		return secondaryRewardItem;
	}

	public void setSecondaryRewardPrice(double secondaryRewardPrice) {
		this.secondaryRewardPrice = secondaryRewardPrice;
	}

	public double getSecondaryRewardPrice() {
		return secondaryRewardPrice;
	}

	public void setRewardItem(ItemStack rewardItem){
		this.rewardItem = rewardItem;
	}

	public ItemStack getRewardItem(){
		return rewardItem;
	}

	public void setRewardPrice(double rewardPrice) {
		this.rewardPrice = rewardPrice;
	}

	public double getRewardPrice() {
		return rewardPrice;
	}

	public void setMaxRadius(int maxRadius){
		this.maxRadius = maxRadius;
	}

	public int getMaxRadius(){
		return maxRadius;
	}

	public String getLocation(){
		return location;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public boolean bettingEnabled(){
		return betting;
	}

	public void setBetting(boolean betting){
		this.betting = betting;
	}
	
	public boolean hasRestoreBlocks(){
		if(restoreBlocks.isEmpty()){
			return false;
		}
		return true;
	}
	
	public void addRestoreBlock(RestoreBlock block){
		restoreBlocks.put(block.getName(), block);
	}
	
	public boolean removeRestoreBlock(String name){
		if(restoreBlocks.containsKey(name)){
			restoreBlocks.remove(name);
			return true;
		}
		return false;
	}
	
	public Map<String, RestoreBlock> getRestoreBlocks(){
		return restoreBlocks;
	}
	
	public boolean hasFlags(){
		return !flags.isEmpty();
	}
	
	public void addFlag(String flag){
		flags.add(flag);
	}
	
	public void setFlags(List<String> flags){
		this.flags = flags;
	}
	
	public List<String> getFlags(){
		return flags;
	}
	
	public boolean removeFlag(String flag){
		if(flags.contains(flag)){
			flags.remove(flag);
			return true;
		}
		return false;
	}
	
	public void setStartLocation(Location loc){
		startLocations.set(0, loc);
	}
	
	public void addStartLocation(Location loc, int number){
		if(startLocations.size() >= number){
			startLocations.set(number - 1, loc);
		}
		else{
			startLocations.add(loc);
		}
	}
	
	public List<Location> getStartLocations(){
		return startLocations;
	}
	
	public boolean removeStartLocation(int locNumber){
		if(startLocations.size() < locNumber){
			startLocations.remove(locNumber);
			return true;
		}
		return false;
	}
	
	public void addLoadoutItem(ItemStack item){
		loadout.add(item);
	}
	
	public List<ItemStack> getLoadout(){
		return loadout;
	}
	
	public boolean removeLoadoutItem(ItemStack item){
		if(loadout.contains(item)){
			loadout.remove(item);
			return true;
		}
		return false;
	}
	
	public boolean isEnabled(){
		return enabled;
	}

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public int getMinPlayers(){
		return minPlayers;
	}

	public void setMinPlayers(int minPlayers){
		this.minPlayers = minPlayers;
	}

	public int getMaxPlayers(){
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers){
		this.maxPlayers = maxPlayers;
	}

	public Location getSpleefFloor1(){
		return spleefFloor1;
	}

	public void setSpleefFloor1(Location spleefFloor1){
		this.spleefFloor1 = spleefFloor1;
	}

	public Location getSpleefFloor2(){
		return spleefFloor2;
	}

	public void setSpleefFloor2(Location spleefFloor2){
		this.spleefFloor2 = spleefFloor2;
	}

	public Location getEndPosition(){
		return endPosition;
	}

	public void setEndPosition(Location endPosition){
		this.endPosition = endPosition;
	}

	public Location getQuitPosition(){
		return quitPosition;
	}

	public void setQuitPosition(Location quitPosition){
		this.quitPosition = quitPosition;
	}

	public Location getLobbyPosition(){
		return lobbyPosisiton;
	}

	public void setLobbyPosition(Location lobbyPosisiton){
		this.lobbyPosisiton = lobbyPosisiton;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public MultiplayerTimer getMpTimer() {
		return mpTimer;
	}

	public void setMpTimer(MultiplayerTimer mpTimer) {
		this.mpTimer = mpTimer;
	}

	public MultiplayerBets getMpBets() {
		return mpBets;
	}

	public void setMpBets(MultiplayerBets mpBets) {
		this.mpBets = mpBets;
	}

	public void setUsePermissions(boolean usePermissions) {
		this.usePermissions = usePermissions;
	}

	public boolean getUsePermissions() {
		return usePermissions;
	}

	public TreasureHuntTimer getThTimer() {
		return thTimer;
	}

	public void setThTimer(TreasureHuntTimer thTimer) {
		this.thTimer = thTimer;
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public void addPlayer(Player player){
		players.add(player);
	}
	
	public void removePlayer(Player player){
		if(players.contains(player)){
			players.remove(player);
		}
	}
	
	public boolean hasPlayers(){
		return !players.isEmpty();
	}

	public List<Player> getRedTeam() {
		return redTeam;
	}

	public void addRedTeamPlayer(Player player) {
		redTeam.add(player);
	}

	public List<Player> getBlueTeam() {
		return blueTeam;
	}

	public void addBlueTeamPlayer(Player player) {
		blueTeam.add(player);
	}

	public int getRedTeamScore() {
		return redTeamScore;
	}

	public void setRedTeamScore(int redTeamScore) {
		this.redTeamScore = redTeamScore;
	}
	
	public void incrementRedTeamScore(){
		redTeamScore++;
	}

	public int getBlueTeamScore() {
		return blueTeamScore;
	}

	public void setBlueTeamScore(int blueTeamScore) {
		this.blueTeamScore = blueTeamScore;
	}
	
	public void incrementBlueTeamScore(){
		blueTeamScore++;
	}

	public int getMinScore() {
		return minScore;
	}

	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	
	public void addStartLocationBlue(Location loc, int number){
		if(startLocationsBlue.size() >= number){
			startLocationsBlue.set(number - 1, loc);
		}
		else{
			startLocationsBlue.add(loc);
		}
	}
	
	public List<Location> getStartLocationsBlue(){
		return startLocationsBlue;
	}
	
	public boolean removeStartLocationBlue(int locNumber){
		if(startLocationsBlue.size() < locNumber){
			startLocationsBlue.remove(locNumber);
			return true;
		}
		return false;
	}
	
	public void addStartLocationRed(Location loc, int number){
		if(startLocationsRed.size() >= number){
			startLocationsRed.set(number - 1, loc);
		}
		else{
			startLocationsRed.add(loc);
		}
	}
	
	public List<Location> getStartLocationsRed(){
		return startLocationsRed;
	}
	
	public boolean removeStartLocationRed(int locNumber){
		if(startLocationsRed.size() < locNumber){
			startLocationsRed.remove(locNumber);
			return true;
		}
		return false;
	}
	
	public int getMaxScorePerPlayer(int playerCount){
		float scorePerPlayer = getMaxScore() / getMaxPlayers();
		int score = (int) Math.round(scorePerPlayer * playerCount);
		if(score < minScore){
			score = minScore;
		}
		return score;
	}

	public int getMinTreasure() {
		return minTreasure;
	}

	public void setMinTreasure(int minTreasure) {
		this.minTreasure = minTreasure;
	}

	public int getMaxTreasure() {
		return maxTreasure;
	}

	public void setMaxTreasure(int maxTreasure) {
		this.maxTreasure = maxTreasure;
	}

	public FloorDegenerator getFloorDegenerator() {
		return sfloordegen;
	}

	public void addFloorDegenerator() {
		sfloordegen = new FloorDegenerator(getSpleefFloor1(), getSpleefFloor2(), this);
	}

	public Material getSpleefFloorMaterial() {
		return spleefFloorMaterial;
	}

	public void setSpleefFloorMaterial(Material spleefFloorMaterial) {
		this.spleefFloorMaterial = spleefFloorMaterial;
	}

	public void saveMinigame(){
		MinigameSave minigame = new MinigameSave(name, "config");
		
		if(!getStartLocations().isEmpty()){
			for(int i = 0; i < getStartLocations().size(); i++){
				Minigames.plugin.mdata.minigameSetLocations(name, getStartLocations().get(i), "startpos." + String.valueOf(i), minigame.getConfig());
			}
		}
		if(!getStartLocationsBlue().isEmpty()){
			for(int i = 0; i < getStartLocationsBlue().size(); i++){
				Minigames.plugin.mdata.minigameSetLocations(name, getStartLocationsBlue().get(i), "startposblue." + String.valueOf(i), minigame.getConfig());
			}
		}
		if(!getStartLocationsRed().isEmpty()){
			for(int i = 0; i < getStartLocationsRed().size(); i++){
				Minigames.plugin.mdata.minigameSetLocations(name, getStartLocationsRed().get(i), "startposred." + String.valueOf(i), minigame.getConfig());
			}
		}
		if(getEndPosition() != null){
			Minigames.plugin.mdata.minigameSetLocations(name, getEndPosition(), "endpos", minigame.getConfig());
		}
		if(getLobbyPosition() != null){
			Minigames.plugin.mdata.minigameSetLocations(name, getLobbyPosition(), "lobbypos", minigame.getConfig());
		}
		if(getQuitPosition() != null){
			Minigames.plugin.mdata.minigameSetLocations(name, getQuitPosition(), "quitpos", minigame.getConfig());
		}
		if(getSpleefFloor1() != null){
			Minigames.plugin.mdata.minigameSetLocations(name, getSpleefFloor1(), "sfloorpos.1", minigame.getConfig());
		}
		if(getSpleefFloor2() != null){
			Minigames.plugin.mdata.minigameSetLocations(name, getSpleefFloor2(), "sfloorpos.2", minigame.getConfig());
		}
		if(getMinTreasure() != 0){
			minigame.getConfig().set(name + ".mintreasure", getMinTreasure());
		}
		if(getMaxTreasure() != 8){
			minigame.getConfig().set(name + ".maxtreasure", getMaxTreasure());
		}
		minigame.getConfig().set(name + ".type", getType());
		minigame.getConfig().set(name + ".minplayers", getMinPlayers());
		minigame.getConfig().set(name + ".maxplayers", getMaxPlayers());
		minigame.getConfig().set(name + ".bets", bettingEnabled());
		minigame.getConfig().set(name + ".enabled", isEnabled());
		minigame.getConfig().set(name + ".maxradius", getMaxRadius());
		minigame.getConfig().set(name + ".usepermissions", usePermissions);
		if(getRewardItem() != null){
			minigame.getConfig().set(name + ".reward", getRewardItem());
		}
		if(getSecondaryRewardItem() != null){
			minigame.getConfig().set(name + ".reward2", getSecondaryRewardItem());
		}
		if(getRewardPrice() != 0){
			minigame.getConfig().set(name + ".rewardprice", getRewardPrice());
		}
		if(getSecondaryRewardPrice() != 0){
			minigame.getConfig().set(name + ".rewardprice2", getSecondaryRewardPrice());
		}
		if(!getFlags().isEmpty()){
			minigame.getConfig().set(name + ".flags", getFlags());
		}
		if(getSpleefFloorMaterial() != Material.SNOW_BLOCK){
			minigame.getConfig().set(name + ".spleeffloormat", getSpleefFloorMaterial().getId());
		}
		if(!getLoadout().isEmpty()){
			minigame.getConfig().set(name + ".loadout", null);
			for(int i = 0; i < getLoadout().size(); i++){
				minigame.getConfig().set(name + ".loadout." + i, getLoadout().get(i));
			}
		}
		else{
			minigame.getConfig().set(name + ".loadout", null);
		}
		if(getMaxScore() != 10){
			minigame.getConfig().set(name + ".maxscore", getMaxScore());
		}
		if(getMinScore() != 5){
			minigame.getConfig().set(name + ".minscore", getMinScore());
		}
		if(!restoreBlocks.isEmpty()){
			Set<String> blocks = restoreBlocks.keySet();
			for(String block : blocks){
				minigame.getConfig().set(name + ".resblocks." + block + ".type", restoreBlocks.get(block).getBlock().toString());
				Minigames.plugin.mdata.minigameSetLocationsShort(name, restoreBlocks.get(block).getLocation(), "resblocks." + block + ".location", minigame.getConfig());
				if(restoreBlocks.get(block).getItems() != null){
					for(int i = 0; i < restoreBlocks.get(block).getItems().length; i++){
						if(restoreBlocks.get(block).getItems()[i] != null){
							minigame.getConfig().set(name + ".resblocks." + block + ".items." + i, restoreBlocks.get(block).getItems()[i]);
						}
					}
				}
			}
		}
		if(getLocation() != null){
			minigame.getConfig().set(name + ".location", getLocation());
		}
		
		minigame.saveConfig();
	}
	
	public void loadMinigame(){
		MinigameSave minigame = new MinigameSave(name, "config");
		
		if(minigame.getConfig().contains(name + ".startpos")){
			Set<String> locs = minigame.getConfig().getConfigurationSection(name + ".startpos").getKeys(false);
			
			for(int i = 0; i < locs.size(); i++){
				addStartLocation(Minigames.plugin.mdata.minigameLocations(name, "startpos." + String.valueOf(i), minigame.getConfig()), i + 1);
			}
		}
		if(minigame.getConfig().contains(name + ".startposred")){
			Set<String> locs = minigame.getConfig().getConfigurationSection(name + ".startposred").getKeys(false);
			
			for(int i = 0; i < locs.size(); i++){
				addStartLocationRed(Minigames.plugin.mdata.minigameLocations(name, "startposred." + String.valueOf(i), minigame.getConfig()), i + 1);
			}
		}
		if(minigame.getConfig().contains(name + ".startposblue")){
			Set<String> locs = minigame.getConfig().getConfigurationSection(name + ".startposblue").getKeys(false);
			
			for(int i = 0; i < locs.size(); i++){
				addStartLocationBlue(Minigames.plugin.mdata.minigameLocations(name, "startposblue." + String.valueOf(i), minigame.getConfig()), i + 1);
			}
		}
		if(minigame.getConfig().contains(name + ".endpos")){
			setEndPosition(Minigames.plugin.mdata.minigameLocations(name, "endpos", minigame.getConfig()));
		}
		if(minigame.getConfig().contains(name + ".lobbypos")){
			setLobbyPosition(Minigames.plugin.mdata.minigameLocations(name, "lobbypos", minigame.getConfig()));
		}
		if(minigame.getConfig().contains(name + ".quitpos")){
			setQuitPosition(Minigames.plugin.mdata.minigameLocations(name, "quitpos", minigame.getConfig()));
		}
		if(minigame.getConfig().contains(name + ".sfloorpos.1")){
			setSpleefFloor1(Minigames.plugin.mdata.minigameLocations(name, "sfloorpos.1", minigame.getConfig()));
		}
		if(minigame.getConfig().contains(name + ".sfloorpos.2")){
			setSpleefFloor2(Minigames.plugin.mdata.minigameLocations(name, "sfloorpos.2", minigame.getConfig()));
		}
		if(minigame.getConfig().contains(name + ".spleeffloormat")){
			setSpleefFloorMaterial(Material.getMaterial(minigame.getConfig().getInt(name + ".spleeffloormat")));
		}
		if(minigame.getConfig().contains(name + ".mintreasure")){
			setMinTreasure(minigame.getConfig().getInt(name + ".mintreasure"));
		}
		if(minigame.getConfig().contains(name + ".maxtreasure")){
			setMaxTreasure(minigame.getConfig().getInt(name + ".maxtreasure"));
		}
		setType(minigame.getConfig().getString(name + ".type"));
		setMinPlayers(minigame.getConfig().getInt(name + ".minplayers"));
		setMaxPlayers(minigame.getConfig().getInt(name + ".maxplayers"));
		setBetting(minigame.getConfig().getBoolean(name + ".bets"));
		setEnabled(minigame.getConfig().getBoolean(name + ".enabled"));
		setMaxRadius(minigame.getConfig().getInt(name + ".maxradius"));
		setUsePermissions(minigame.getConfig().getBoolean(name + ".usepermissions"));
		if(minigame.getConfig().contains(name + ".reward")){
			setRewardItem(minigame.getConfig().getItemStack(name + ".reward"));
		}
		if(minigame.getConfig().contains(name + ".reward2")){
			setSecondaryRewardItem(minigame.getConfig().getItemStack(name + ".reward2"));
		}
		if(minigame.getConfig().contains(name + ".rewardprice")){
			setRewardPrice(minigame.getConfig().getDouble(name + ".rewardprice"));
		}
		if(minigame.getConfig().contains(name + ".rewardprice2")){
			setSecondaryRewardPrice(minigame.getConfig().getDouble(name + ".rewardprice2"));
		}
		if(!minigame.getConfig().getStringList(name + ".flags").isEmpty()){
			setFlags(minigame.getConfig().getStringList(name + ".flags"));
		}
		if(minigame.getConfig().contains(name + ".loadout")){
			Set<String> keys = minigame.getConfig().getConfigurationSection(name + ".loadout").getKeys(false);
			for(int i = 0; i < keys.size(); i++){
				addLoadoutItem(minigame.getConfig().getItemStack(name + ".loadout." + i));
			}
		}
		if(minigame.getConfig().contains(name + ".maxscore")){
			setMaxScore(minigame.getConfig().getInt(name + ".maxscore"));
		}
		if(minigame.getConfig().contains(name + ".minscore")){
			setMinScore(minigame.getConfig().getInt(name + ".minscore"));
		}
		if(minigame.getConfig().contains(name + ".resblocks") && minigame.getConfig().getString(name + ".resblocks") != "true" && minigame.getConfig().getString(name + ".resblocks") != "false"){
			Set<String> blocks = minigame.getConfig().getConfigurationSection(name + ".resblocks").getKeys(false);
			for(String block : blocks){
				RestoreBlock res = new RestoreBlock(block, Material.getMaterial(minigame.getConfig().getString(name + ".resblocks." + block + ".type")), Minigames.plugin.mdata.minigameLocationsShort(name, ".resblocks." + block + ".location", minigame.getConfig()));
				if(minigame.getConfig().contains(name + ".resblocks." + block + ".items")){
					Set<String> itemset = minigame.getConfig().getConfigurationSection(name + ".resblocks." + block + ".items").getKeys(false);
					if(!itemset.isEmpty()){
						InventoryType type = null;
						if(res.getBlock().toString().equals("CHEST")){
							type = InventoryType.CHEST;
						}
						else if(res.getBlock().toString().equals("DISPENSER")){
							type = InventoryType.DISPENSER;
						}
						else if(res.getBlock().toString().equals("FURNACE")){
							type = InventoryType.FURNACE;
						}
						ItemStack[] items = new ItemStack[Minigames.plugin.getServer().createInventory(null, type).getSize()];
						for(String item : itemset){
							items[Integer.parseInt(item)] = minigame.getConfig().getItemStack(name + ".resblocks." + block + ".items." + item);
						}
						res.setItems(items);
					}
				}
				addRestoreBlock(res);
			}
		}
		if(minigame.getConfig().contains(name + ".location")){
			setLocation(minigame.getConfig().getString(name + ".location"));
		}
		
		saveMinigame();
	}
}