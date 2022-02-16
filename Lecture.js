class Lecture {

    #serialVersionUID;
    #id;
    #lectureName;
    #modulName;
    #duration;
    #lectureDates;
    #lecturers;
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

    getLectureName() {
        return this.#lectureName;
    }

    setLectureName(lectureName) {
        this.#lectureName = lectureName;
    }

    getModulName() {
        return this.#modulName;
    }

    setModulName(modulName) {
        this.#modulName = modulName;
    }

    getDuration() {
        return this.#duration;
    }

    setDuration(duration) {
        this.#duration = duration;
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

    getLecturers() {
        return this.#lecturers
    }

    addLecture(lecturer) {
        this.#lecturers.push(lecturer)
    }

    removeLecture(lecturers) {
        this.#lecturers.pop(lecturers)
    }

    setLecturers(lecturers) {
        this.#lecturers= lecturers
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