/**
 * <a href="http://www.openolat.org">
 * OpenOLAT - Online Learning and Training</a><br>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); <br>
 * you may not use this file except in compliance with the License.<br>
 * You may obtain a copy of the License at the
 * <a href="http://www.apache.org/licenses/LICENSE-2.0">Apache homepage</a>
 * <p>
 * Unless required by applicable law or agreed to in writing,<br>
 * software distributed under the License is distributed on an "AS IS" BASIS, <br>
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. <br>
 * See the License for the specific language governing permissions and <br>
 * limitations under the License.
 * <p>
 * Initial code contributed and copyrighted by<br>
 * frentix GmbH, http://www.frentix.com
 * <p>
 */
package org.olat.selenium.page.qti;

import org.olat.selenium.page.graphene.OOGraphene;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * Drive the feedbackabck editor with the special empty / answered
 * feedbacks.
 * 
 * Initial date: 12 mai 2017<br>
 * @author srosse, stephane.rosse@frentix.com, http://www.frentix.com
 *
 */
public class QTI21LobFeedbacksEditorPage {
	
	private final WebDriver browser;
	
	public QTI21LobFeedbacksEditorPage(WebDriver browser) {
		this.browser = browser;
	}
	
	public QTI21LobFeedbacksEditorPage setHint(String title, String hint) {
		By titleBy = By.cssSelector("div.o_sel_assessment_item_hint_title input[type='text']");
		browser.findElement(titleBy).sendKeys(title);
		OOGraphene.tinymce(hint, "div.o_sel_assessment_item_hint", browser);
		return this;
	}
	
	public QTI21LobFeedbacksEditorPage setCorrectSolution(String title, String correctSolution) {
		By titleBy = By.cssSelector("div.o_sel_assessment_item_correct_solution_title input[type='text']");
		browser.findElement(titleBy).sendKeys(title);
		OOGraphene.tinymce(correctSolution, "div.o_sel_assessment_item_correct_solution", browser);
		return this;
	}
	
	public QTI21LobFeedbacksEditorPage setAnsweredFeedback(String title, String feedback) {
		By titleBy = By.cssSelector("div.o_sel_assessment_item_answered_feedback_title input[type='text']");
		browser.findElement(titleBy).sendKeys(title);
		OOGraphene.tinymce(feedback, "div.o_sel_assessment_item_answered_feedback", browser);
		return this;
	}
	
	public QTI21LobFeedbacksEditorPage setEmpytFeedback(String title, String feedback) {
		By titleBy = By.cssSelector("div.o_sel_assessment_item_empty_feedback_title input[type='text']");
		browser.findElement(titleBy).sendKeys(title);
		OOGraphene.tinymce(feedback, "div.o_sel_assessment_item_empty_feedback", browser);
		return this;
	}

	public QTI21LobFeedbacksEditorPage save() {
		By saveBy = By.cssSelector("fieldset.o_sel_assessment_item_feedbacks button.btn.btn-primary");
		browser.findElement(saveBy).click();
		OOGraphene.waitBusy(browser);
		return this;
	}
}