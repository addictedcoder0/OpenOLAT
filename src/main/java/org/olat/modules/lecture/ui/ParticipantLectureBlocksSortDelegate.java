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
package org.olat.modules.lecture.ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.olat.core.commons.persistence.SortKey;
import org.olat.core.gui.components.form.flexible.impl.elements.table.SortableFlexiTableModelDelegate;
import org.olat.modules.lecture.model.LectureBlockAndRollCall;
import org.olat.modules.lecture.ui.ParticipantLectureBlocksDataModel.ParticipantCols;

/**
 * 
 * Initial date: 29 mars 2017<br>
 * @author srosse, stephane.rosse@frentix.com, http://www.frentix.com
 *
 */
public class ParticipantLectureBlocksSortDelegate extends SortableFlexiTableModelDelegate<LectureBlockAndRollCall> {

	public ParticipantLectureBlocksSortDelegate(SortKey orderBy, ParticipantLectureBlocksDataModel tableModel, Locale locale) {
		super(orderBy, tableModel, locale);
	}
	
	@Override
	protected void sort(List<LectureBlockAndRollCall> rows) {
		int columnIndex = getColumnIndex();
		ParticipantCols column = ParticipantCols.values()[columnIndex];
		switch(column) {
			case lectureBlock: Collections.sort(rows, new AttendedLecturesComparator()); break;
			default: {
				super.sort(rows);
			}
		}
	}
	
	private class AttendedLecturesComparator implements Comparator<LectureBlockAndRollCall> {
		@Override
		public int compare(LectureBlockAndRollCall o1, LectureBlockAndRollCall o2) {
			boolean c1 = o1.isRollCalled();
			boolean c2 = o2.isRollCalled();
			int c = compareBooleans(c1, c2);
			if(c == 0) {
				int l1 = o1.getLecturesAttendedNumber();
				int l2 = o2.getLecturesAttendedNumber();
				c = compareInts(l1, l2);
			}
			return c;
		}
	}
}