import {Group} from "./group";
import {Supervisor} from "./supervisor";

export interface Student {
  studentId: number;
  studentName: string;
  group: Group;
  topic: string;
  supervisor: Supervisor;
  email: string;
  phone: string;
}
