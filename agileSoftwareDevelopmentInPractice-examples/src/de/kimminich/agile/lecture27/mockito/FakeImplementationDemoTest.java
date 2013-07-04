package de.kimminich.agile.lecture27.mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FakeImplementationDemoTest {

	AbsenceDeterminator absenceDeterminator;

	@Mock
	StudentSearchService studentSearchService;

	@Before
	public void setUp() {
		absenceDeterminator = new AbsenceDeterminator(studentSearchService);
	}

	@Test
	public void shouldFindPermanentlyAbsentStudentInGroup() {
		// assume
		String[] studentGroupA = { "Amber Miller", "Terry Stone", "John Doe", "Jimmy Morgan" };
		// given
		given(studentSearchService.findStudentsInGroup("A")).willReturn(studentGroupA);
		// when
		List<String> absentStudents = absenceDeterminator.findAbsentStudents("A");
		// then
		assertThat(absentStudents, allOf(hasSize(1), contains("John Doe")));

		verify(studentSearchService).findStudentsInGroup("A");
		verify(studentSearchService, never()).findStudentsInGroup("B");
		verifyNoMoreInteractions(studentSearchService);

	}


	public class AbsenceDeterminator {
		StudentSearchService studentSearchService;

		public AbsenceDeterminator(StudentSearchService studentSearchService) {
			this.studentSearchService = studentSearchService;
		}

		public List<String> findAbsentStudents(String groupId) {
			String[] allStudents = studentSearchService.findStudentsInGroup(groupId);
			return filterAbsent(allStudents);
		}

		private List<String> filterAbsent(String... students) {
			List<String> absentStudents = new ArrayList<>();
			for (String student : students) {
				if (student.equals("John Doe")) { // He *never* shows up
					absentStudents.add("John Doe");
				} else {
					// TODO Find unexpectedly absent students
				}
			}
			return absentStudents;
		}
	}

	public interface StudentSearchService {
		String[] findStudentsInGroup(String groupId);
	}

}
