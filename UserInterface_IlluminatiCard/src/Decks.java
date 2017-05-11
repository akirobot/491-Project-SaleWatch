import java.util.ArrayList;


public class Decks {

	
	public final static int DEFAULT_WIDTH = 80, DEFAULT_HEIGHT = 50;
	
	
	//Illuminati cards
	public static IlluminatiCard The_Society_Of_Assassins, The_Net_work, The_Discordian_Society, The_UFOs, 
		The_Servants_Of_Cthulhu, The_Gnomes_Of_Zurich, The_Bavarian_Illuminati, The_Bermuda_Triangle;
		
	//Special cards
	public static SpecialCard Assassination, Bribery, Computer_Espionage, Deep_Agent, Inter_Ference_1, 
		Inter_Ference_2, Market_Manipulation, Media_Campaign, Murphays_Law, Secrets_Man_Was_Not_Meant_To_Know, 
		Senate_Invesigating_Committee, Slush_Fund, Swiss_Bank_Account, Whispering_Campaign, White_Collar_Crime;
		
	//Group cards
	public static GroupCard American_Autoduel_Association, AntiNuclear_Activists, Antiwar_Activists, Big_Media, 
		Boy_Sprouts, California, CFL_AIO, Chinese_Campaign_Donors, CIA, Comic_Book, Congressional_Wives,
		Conveninece_Stores, Copy_Shops, Cycle_Gangs, Democrats, Eco_Guerrillas, Empty_Vee, 
		Evil_Geniuses_For_A_Better_Tomorrow, Fast_Food_Chains, FBI, Federal_Reserve, Feminists, 
		Fiendish_Fluoridators, Flat_Earthers, Fnord_Motor_Company, Fraternal_Orders, Girlie_Magazine,
		Goldfish_Fanciers, Gun_Lobby, Hacker, Health_Food_Stores, Hollywood, Intellectuals,
		International_Cocaine_Smugglers, International_Communist_Conspiracy, IRS, Junk_Mail, KGB,
		KKK, L_4_Society, Libertarians, Loan_Sharks, Local_Police_Departments, Madison_Avenue, The_Mafia,
		The_Men_In_Black, Militia, Moonies, Moral_Minority, Morticians, Multinational_Oil_Companies, 
		Nephews_Of_God, New_York, Nuclear_Power_Companies, Orbital_Mind_Control_Lasers,
		Parent_Teacher_Agglomeration, Pentagon, The_Phone_Company, Phone_Phreaks, Post_Office, Professional_Sports,
		Psychiatrists, Punk_Rockers, Recyclers, Republicans, Robot_Sea_Monsters, Science_Fiction_Fans,
		Semiconscious_Liberation_Army, SMOF, Society_for_Creative_Anarchism, South_American_Nazis, Survivalists,
		Tabloids, Texas, Tobacco_Liquor_Companies, Trekkies, Triliberal_Commission, Underground_Newspaper,
		The_United_Nations, Video_Games, Yuppies;
		
	
	
	private static ArrayList<SpecialCard> specialCard;
	private static ArrayList<IlluminatiCard> illuminatiCard;
	private static ArrayList<GroupCard> groupCard;
	
	public static void init() {
		
		specialCard = new ArrayList<SpecialCard>();
		illuminatiCard = new ArrayList<IlluminatiCard>();
		groupCard = new ArrayList<GroupCard>();
		
		
		//Special cards
		Assassination = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Assassination",
				CardType.Special, Assets.Assassination, Assets.specialBack,
				false);
		Bribery = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Bribery",
				CardType.Special, Assets.Bribery, Assets.specialBack,
				false);
		Computer_Espionage = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Computer Espionage",
				CardType.Special, Assets.Computer_Espionage, Assets.specialBack,
				false);
		Deep_Agent = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Deep Agent",
				CardType.Special, Assets.Deep_Agent, Assets.specialBack,
				false);
		Inter_Ference_1 = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Inter Ference 1",
				CardType.Special, Assets.Inter_Ference_1, Assets.specialBack,
				false);
		Inter_Ference_2 = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Inter Ference 2",
				CardType.Special, Assets.Inter_Ference_2, Assets.specialBack,
				false);
		Market_Manipulation = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Market Manipulation",
				CardType.Special, Assets.Market_Manipulation, Assets.specialBack,
				false);
		Media_Campaign = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Media Campaign",
				CardType.Special, Assets.Media_Campaign, Assets.specialBack,
				false);
		Murphays_Law = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Murphays Law",
				CardType.Special, Assets.Murphays_Law, Assets.specialBack,
				false);
		Secrets_Man_Was_Not_Meant_To_Know = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Secrets Man Was Not Meant To Know",
				CardType.Special, Assets.Secrets_Man_Was_Not_Meant_To_Know, Assets.specialBack,
				false);
		Senate_Invesigating_Committee = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Senate Invesigating Committee",
				CardType.Special, Assets.Senate_Invesigating_Committee, Assets.specialBack,
				false);
		Slush_Fund = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Slush Fund",
				CardType.Special, Assets.Slush_Fund, Assets.specialBack,
				false);
		Swiss_Bank_Account = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Swiss Bank Account",
				CardType.Special, Assets.Swiss_Bank_Account, Assets.specialBack,
				false);
		Whispering_Campaign = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "Whispering Campaign",
				CardType.Special, Assets.Whispering_Campaign, Assets.specialBack,
				false);
		White_Collar_Crime = new SpecialCard(10, DEFAULT_HEIGHT * 2 + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "White Collar Crime",
				CardType.Special, Assets.White_Collar_Crime, Assets.specialBack,
				false);
		
		specialCard.add(Assassination);
		specialCard.add(Bribery);
		specialCard.add(Computer_Espionage);
		specialCard.add(Deep_Agent);
		specialCard.add(Inter_Ference_1);
		specialCard.add(Inter_Ference_2);
		specialCard.add(Market_Manipulation);
		specialCard.add(Media_Campaign);
		specialCard.add(Murphays_Law);
		specialCard.add(Secrets_Man_Was_Not_Meant_To_Know);
		specialCard.add(Senate_Invesigating_Committee);
		specialCard.add(Slush_Fund);
		specialCard.add(Swiss_Bank_Account);
		specialCard.add(Whispering_Campaign);
		specialCard.add(White_Collar_Crime);
		
		
		//Illuminati cards
		The_Society_Of_Assassins = new IlluminatiCard (0, DEFAULT_HEIGHT + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "The Society Of Assassins",
				CardType.Illuminati, Assets.The_Society_Of_Assassins, Assets.illuminatiBack,
				false, 8, 8, 8);
		The_Net_work = new IlluminatiCard (0, DEFAULT_HEIGHT + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "The Net work",
				CardType.Illuminati, Assets.The_Net_work, Assets.illuminatiBack,
				false, 7, 7, 9);
		The_Discordian_Society = new IlluminatiCard (0, DEFAULT_HEIGHT + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "The Discordian Society",
				CardType.Illuminati, Assets.The_Discordian_Society, Assets.illuminatiBack,
				false, 8, 8, 8);
		The_UFOs = new IlluminatiCard (0, DEFAULT_HEIGHT + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "The UFOs",
				CardType.Illuminati, Assets.The_UFOs, Assets.illuminatiBack,
				false, 6, 6, 8);
		The_Servants_Of_Cthulhu = new IlluminatiCard (0, DEFAULT_HEIGHT + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "The Servants Of Cthulhu",
				CardType.Illuminati, Assets.The_Servants_Of_Cthulhu, Assets.illuminatiBack,
				false, 9, 9, 7);
		The_Gnomes_Of_Zurich = new IlluminatiCard (0, DEFAULT_HEIGHT + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "The Gnomes Of Zurich",
				CardType.Illuminati, Assets.The_Gnomes_Of_Zurich, Assets.illuminatiBack,
				false, 7, 7, 12);
		The_Bavarian_Illuminati = new IlluminatiCard (0, DEFAULT_HEIGHT + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "The Bavarian Illuminati",
				CardType.Illuminati, Assets.The_Bavarian_Illuminati, Assets.illuminatiBack,
				false, 10, 10, 9);
		The_Bermuda_Triangle = new IlluminatiCard (0, DEFAULT_HEIGHT + 20, DEFAULT_WIDTH, DEFAULT_HEIGHT, "The Bermuda Triangle",
				CardType.Illuminati, Assets.The_Bermuda_Triangle, Assets.illuminatiBack,
				false, 8, 8, 8);
		
		illuminatiCard.add(The_Society_Of_Assassins);
		illuminatiCard.add(The_Net_work);
		illuminatiCard.add(The_Discordian_Society);
		illuminatiCard.add(The_UFOs);
		illuminatiCard.add(The_Servants_Of_Cthulhu);
		illuminatiCard.add(The_Gnomes_Of_Zurich);
		illuminatiCard.add(The_Bavarian_Illuminati);
		illuminatiCard.add(The_Bermuda_Triangle);
		
		
		
		
		
		
		
		//Group cards
		American_Autoduel_Association = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		American_Autoduel_Association = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		AntiNuclear_Activists = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Antiwar_Activists = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Big_Media = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Boy_Sprouts = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		California = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		CFL_AIO = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Chinese_Campaign_Donors = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		CIA = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Comic_Book = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Congressional_Wives = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Conveninece_Stores = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Copy_Shops = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Cycle_Gangs = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Democrats = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Eco_Guerrillas = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Empty_Vee = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Evil_Geniuses_For_A_Better_Tomorrow = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Fast_Food_Chains = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		FBI = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Federal_Reserve = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Feminists = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Fiendish_Fluoridators = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Flat_Earthers = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Fnord_Motor_Company = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Fraternal_Orders = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Girlie_Magazine = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Goldfish_Fanciers = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Gun_Lobby = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Hacker = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Health_Food_Stores = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Hollywood = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Intellectuals = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		International_Cocaine_Smugglers = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		International_Communist_Conspiracy = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		IRS = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Junk_Mail = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		KGB = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		KKK = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		L_4_Society = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Libertarians = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Loan_Sharks = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Local_Police_Departments = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Madison_Avenue = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		The_Mafia = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		The_Men_In_Black = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Militia = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Moonies = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Moral_Minority = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Morticians = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Multinational_Oil_Companies = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Nephews_Of_God = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		New_York = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Nuclear_Power_Companies = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Orbital_Mind_Control_Lasers = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Parent_Teacher_Agglomeration = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Pentagon = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		The_Phone_Company = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Phone_Phreaks = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Post_Office = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Professional_Sports = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Psychiatrists = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Punk_Rockers = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Recyclers = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Republicans = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Robot_Sea_Monsters = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Science_Fiction_Fans = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Semiconscious_Liberation_Army = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		SMOF = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Society_for_Creative_Anarchism = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		South_American_Nazis = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Survivalists = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Tabloids = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Texas = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Tobacco_Liquor_Companies = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Trekkies = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Triliberal_Commission = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Underground_Newspaper = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		The_United_Nations = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Video_Games = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);
		Yuppies = new GroupCard(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT, "", CardType.Group, Assets.Big_Media, Assets.groupBack, 
				false, 0, 0, 0, 0, new ArrowGoing[]{ArrowGoing.in,ArrowGoing.none,ArrowGoing.out,ArrowGoing.none}, false);

	}

}
