class StudyProgram {

    #serialVersionUID;
    #id;
    #name;
    #shortname;
    #studyClasses;
    #lectures;
    #lecturers;

    getLecturers() {
        return this.#lecturers;
    }

    addLecturers(lecturers) {
        this.#lecturers.push(lecturers)
    }

    removeLecturer(lecturer){
        this.#lecturers.pop(lecturer)
    }

    getLectures() {
        return this.#lectures;
    }

    addLecture(lecture) {
        this.#lecture.push(lecture)
    }

    setLectures(lectures) {
        this.#lectures = lectures
    }

    removeLecture(lecture){
        this.#lecture.pop(lecture)
    }

    getId() {
        return this.#id;
    }

    setId(id) {
        this.#id = id;
    }

    getName() {
        return this.#name;
    }

    setName(name) {
        this.#name = name;
    }

    getShortName() {
        return this.#shortname;
    }

    setShortName(shortname) {
        this.#shortname = shortname;
    }

    getStudyClasses() {
        return this.#studyClasses
    }

    addStudyClass(studyClass) {
        this.#studyClasses.push(studyClass)
    }

    removeStudyClass(studyClass){
        this.#studyClasses.pop(studyClass)
    }

    setStudyClasses(studyClasses){
        this.#studyClasses = studyClasses
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