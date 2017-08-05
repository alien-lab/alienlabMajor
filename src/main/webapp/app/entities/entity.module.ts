import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AlienlabMajorBaseTermModule } from './base-term/base-term.module';
import { AlienlabMajorBaseDepartmentModule } from './base-department/base-department.module';
import { AlienlabMajorBaseTeacherModule } from './base-teacher/base-teacher.module';
import { AlienlabMajorBaseMajorModule } from './base-major/base-major.module';
import { AlienlabMajorBaseCourseModule } from './base-course/base-course.module';
import { AlienlabMajorCourseVersionModule } from './course-version/course-version.module';
import { AlienlabMajorCourseGroupModule } from './course-group/course-group.module';
import { AlienlabMajorCourseGroupItemModule } from './course-group-item/course-group-item.module';
import { AlienlabMajorCourseTreeModule } from './course-tree/course-tree.module';
import { AlienlabMajorBaseMajorCourseModule } from './base-major-course/base-major-course.module';
import { AlienlabMajorBaseClassesModule } from './base-classes/base-classes.module';
import { AlienlabMajorBaseTeachTaskModule } from './base-teach-task/base-teach-task.module';
import { AlienlabMajorBaseResourceTypeModule } from './base-resource-type/base-resource-type.module';
import { AlienlabMajorBaseResourceModule } from './base-resource/base-resource.module';
import { AlienlabMajorTeacherResourceModule } from './teacher-resource/teacher-resource.module';
import { AlienlabMajorCourseResourceModule } from './course-resource/course-resource.module';
import { AlienlabMajorCourseStructModule } from './course-struct/course-struct.module';
import { AlienlabMajorCourseOnClassModule } from './course-on-class/course-on-class.module';
import { AlienlabMajorCourseTalkModule } from './course-talk/course-talk.module';
import { AlienlabMajorResourceCommentModule } from './resource-comment/resource-comment.module';
import { AlienlabMajorTeacherCommentModule } from './teacher-comment/teacher-comment.module';
import { AlienlabMajorMajorTraningModule } from './major-traning/major-traning.module';
import { AlienlabMajorTraningStructModule } from './traning-struct/traning-struct.module';
import { AlienlabMajorTraningStructRelationModule } from './traning-struct-relation/traning-struct-relation.module';
import { AlienlabMajorTraningDataModule } from './traning-data/traning-data.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        AlienlabMajorBaseTermModule,
        AlienlabMajorBaseDepartmentModule,
        AlienlabMajorBaseTeacherModule,
        AlienlabMajorBaseMajorModule,
        AlienlabMajorBaseCourseModule,
        AlienlabMajorCourseVersionModule,
        AlienlabMajorCourseGroupModule,
        AlienlabMajorCourseGroupItemModule,
        AlienlabMajorCourseTreeModule,
        AlienlabMajorBaseMajorCourseModule,
        AlienlabMajorBaseClassesModule,
        AlienlabMajorBaseTeachTaskModule,
        AlienlabMajorBaseResourceTypeModule,
        AlienlabMajorBaseResourceModule,
        AlienlabMajorTeacherResourceModule,
        AlienlabMajorCourseResourceModule,
        AlienlabMajorCourseStructModule,
        AlienlabMajorCourseOnClassModule,
        AlienlabMajorCourseTalkModule,
        AlienlabMajorResourceCommentModule,
        AlienlabMajorTeacherCommentModule,
        AlienlabMajorMajorTraningModule,
        AlienlabMajorTraningStructModule,
        AlienlabMajorTraningStructRelationModule,
        AlienlabMajorTraningDataModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AlienlabMajorEntityModule {}
