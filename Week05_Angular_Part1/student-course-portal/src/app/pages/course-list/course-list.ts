import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCard } from '../../components/course-card/course-card';
import { CourseService } from '../../services/course';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  imports: [CommonModule, CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList implements OnInit {
  courses = signal<Course[]>([]);
  isLoading = signal(true);
  selectedCourseId = signal<number | null>(null);

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    setTimeout(() => {
      this.courses.set(this.courseService.getCourses());
      this.isLoading.set(false);
    }, 1500);
  }

  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId.set(courseId);
  }
}
