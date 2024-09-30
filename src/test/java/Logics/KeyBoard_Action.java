package Logics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyBoard_Action {

	public static void main(String[] args) {
		
		String staticOTP="Hello";
		try {
			//AndroidDriver driver = (AndroidDriver) nlpRequestModel.getDriver().getSpecificIDriver();
			WebDriver driver= new ChromeDriver();
			char[] c = staticOTP.toCharArray();
			for (int i = 0; i < c.length; i++) {

				switch (c[i]) {
				case '@':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.AT));
					break;
				case '.':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.PERIOD));
					break;
				case 'A':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.A));
					break;
				case 'B':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.B));
					break;
				case 'C':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.C));
					break;
				case 'D':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.D));
					break;
				case 'E':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.E));
					break;
				case 'F':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.F));
					break;
				case 'G':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.G));
					break;
				case 'H':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.H));
					break;
				case 'I':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.I));
					break;
				case 'J':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.J));
					break;
				case 'K':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.K));
					break;
				case 'L':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.L));
					break;
				case 'M':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.M));
					break;
				case 'N':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.N));
					break;
				case 'O':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.O));
					break;
				case 'P':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.P));
					break;
				case 'Q':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.Q));
					break;
				case 'R':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.R));
					break;
				case 'S':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.S));
					break;
				case 'T':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.T));
					break;
				case 'U':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.U));
					break;
				case 'V':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.V));
					break;
				case 'W':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.W));
					break;
				case 'X':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.X));
					break;
				case 'Y':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.Y));
					break;
				case 'Z':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.Z));
					break;
				case '0':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_0));
					break;
				case '1':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
					break;
				case '2':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
					break;
				case '3':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
					break;
				case '4':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_4));
					break;
				case '5':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_5));
					break;
				case '6':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_6));
					break;
				case '7':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_7));
					break;
				case '8':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_8));
					break;
				case '9':
					driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_9));
					break;
				default:
					nlpResponseModel.setStatus(CommonConstants.fail);
					nlpResponseModel.setMessage("Not match to the Dial Keypad");
					break;
				}

				nlpResponseModel.setStatus(CommonConstants.pass);
				nlpResponseModel.setMessage("Clicked on Dial Keypad " + staticOTP);
			}
		}
	}
}
