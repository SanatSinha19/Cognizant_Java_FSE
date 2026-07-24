import { Component } from '@angular/core';
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-course-summary-widget',
  imports: [],
  templateUrl: './course-summary-widget.html',
  styleUrl: './course-summary-widget.css',
})
export class CourseSummaryWidget {
  constructor(private courseService: CourseService) {}

  get totalCourses(): number {
    return this.courseService.getCourses().length;
  }

  addSampleCourse(): void {
    this.courseService.addCourse({
      id: Date.now(),
      name: 'New Sample Course',
      code: 'CS' + Math.floor(Math.random() * 900 + 100),
      credits: 3,
      gradeStatus: 'pending',
    });
  }
}
