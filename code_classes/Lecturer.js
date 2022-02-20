class Lecturer {

    #serialVersionUID;
    #id;
    #firstName;
    #lastName;
    #email;
    #lectureDates;
    #lectures;
    #studyProgram;
    

    getStudyProgram() {
        return this.#studyProgram;
    }

    setStudyProgram(StudyProgram) {
        this.#studyProgram = StudyProgram;
    }

    getId() {
        return this.#id;
    }

    setId(id) {
        this.#id = id;
    }

    getFirstName() {
        return this.#firstName;
    }

    setFirstName(firstName) {
        this.#firstName = firstName;
    }

    getLastName() {
        return this.#lastName;
    }

    setLastName(lastName) {
        this.#lastName = lastName;
    }

    getEmail() {
        return this.#email;
    }

    setEmail(email) {
        this.#email = email;
    }
 
    getLectureDates() {
        return this.#lectureDates;
    }

    addLectureDate(lectureDate) {
        this.#lectureDates.push(lectureDate);
    }

    removeLectureDate(lectureDate) {
        this.#lectureDates.pop(lectureDate);
    }

    setLectureDates(lectureDates) {
        this.#lectureDates = lectureDates;
    }

    getLectures() {
        return this.#lectures
    }

    addLecture(lecture) {
        this.#lectures.push(lecture)
    }

    removeLecture(lectures) {
        this.#lectures.pop(lectures)
    }

    setLectures(lectures) {
        this.#lectures= lectures
    }

    equals(Object) {
        //???
        return boolean;
    }

    hashCode(){
        //???
        return 0;
    }

    toString(){
        //????
    }
}