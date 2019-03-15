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
package org.olat.core.commons.services.vfs;

import java.io.File;
import java.nio.file.Path;

import org.olat.core.commons.modules.bc.FolderConfig;
import org.olat.core.util.vfs.VFSConstants;
import org.olat.core.util.vfs.VFSStatus;

/**
 * 
 * Initial date: 11 mars 2019<br>
 * @author srosse, stephane.rosse@frentix.com, http://www.frentix.com
 *
 */
public class VFSRepositoryModule {
	
	public static final VFSStatus canMeta(File file) {
		Path bFile = file.toPath();
		Path bcRoot = FolderConfig.getCanonicalRootPath();
		String filename = file.getName();
		return bFile.startsWith(bcRoot)
				&& !bFile.startsWith(FolderConfig.getCanonicalMetaRootPath())
				&& !bFile.startsWith(FolderConfig.getCanonicalVersionRootPath())
				&& !bFile.startsWith(FolderConfig.getCanonicalTmpPath())
				&& !file.isHidden()
				&& !filename.startsWith("._oo_")
				? VFSConstants.YES : VFSConstants.NO;
	}

}