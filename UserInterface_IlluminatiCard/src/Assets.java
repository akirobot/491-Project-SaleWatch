import java.awt.image.BufferedImage;


public class Assets {

	public static BufferedImage[] start_BTN;
	
	//Illuminati cards
	public static BufferedImage The_Society_Of_Assassins, The_Net_work, The_Discordian_Society, The_UFOs, 
		The_Servants_Of_Cthulhu, The_Gnomes_Of_Zurich, The_Bavarian_Illuminati, The_Bermuda_Triangle;
	
	//Special cards
	public static BufferedImage Assassination, Bribery, Computer_Espionage, Deep_Agent, Inter_Ference_1, 
		Inter_Ference_2, Market_Manipulation, Media_Campaign, Murphays_Law, Secrets_Man_Was_Not_Meant_To_Know, 
		Senate_Invesigating_Committee, Slush_Fund, Swiss_Bank_Account, Whispering_Campaign, White_Collar_Crime;
	
	//Group cards
	public static BufferedImage American_Autoduel_Association, AntiNuclear_Activists, Antiwar_Activists, Big_Media, 
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
	
	
	public static BufferedImage groupBack;
	public static BufferedImage specialBack;
	public static BufferedImage illuminatiBack;
	public static BufferedImage logo;
	public static BufferedImage leftBanner;
	public static BufferedImage rightBanner;
	
	public static void init(){
		
		//Sprite sheets for 3 types of cards
		//SpriteSheet SpecialCards = new SpriteSheet(ImageLoader.loadImages("specialCards"));
		//SpriteSheet IlluminatiCards = new SpriteSheet(ImageLoader.loadImages("IlluminatiCards"));
		//SpriteSheet GroupCards = new SpriteSheet(ImageLoader.loadImages("GroupCards"));
		
		//Logo
		SpriteSheet banners = new SpriteSheet(ImageLoader.loadImages("banner"));
		leftBanner = banners.crop(0, 0, 180, 600);
		rightBanner = banners.crop(220, 0, 180, 600);
		logo = ImageLoader.loadImages("logo");
		//Start button
		start_BTN = new BufferedImage[2];
		start_BTN[0] = ImageLoader.loadImages("start_BTN_1");
		start_BTN[1] = ImageLoader.loadImages("start_BTN_2");
	}
}
