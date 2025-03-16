package com.trello.qspider.createanddeleteboard;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.trello.qspiders.genericutility.BaseClass;
import com.trello.qspiders.pomrepository.TrelloBoardsPage;
import com.trello.qspiders.pomrepository.TrelloCreatedBoardPage;

public class EndToEndScenario extends BaseClass {
	@Test
	public void createAndDeleteBorad() throws Throwable {
		TrelloBoardsPage boardPage = new TrelloBoardsPage(driver);
		boardPage.createNewBoard().click();
		boardPage.createBoardTitleTextFiled().sendKeys(fileUtile.readDataFromProertyFiles("./src/test/resources/marvelcommondata.properties", "boardname"));
		boardPage.createButton().click();
		TrelloCreatedBoardPage createdBoardsPage = new TrelloCreatedBoardPage(driver);
		for (int i=0; i<6; i++) {
			createdBoardsPage.newListTitleTextField().sendKeys(excelUtile.readStringDataFromExcel("./src/test/resources/marvel.xlsx", "marvelassamble", 0, i));
			System.out.println(excelUtile.readStringDataFromExcel("./src/test/resources/marvel.xlsx", "marvelassamble", 0, i));
			createdBoardsPage.newListTitleTextField().sendKeys(Keys.ENTER);
		}
		createdBoardsPage.showMenuOption().click();
		createdBoardsPage.moreOptions().click();
		createdBoardsPage.closeBoardOption().click();
		createdBoardsPage.closeBoardButton().click();
		createdBoardsPage.permanentlyDeleteBoardOption().click();
		createdBoardsPage.deleteBoardButton().click();
	}
}
