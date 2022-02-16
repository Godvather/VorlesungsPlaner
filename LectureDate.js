class LectureDate {

    #serialVersionUID;
    #startDate;
    #endDate;
    #lecturer;
    #lecture;
    #semester;

    getId() {
        return this.#id;
    }

    setId(id) {
        this.#id = id;
    }

    getStartDate() {
        return this.#startDate;
    }

    setStartDate(startDate) {
        this.#startDate = startDate;
    }

    getEndDate() {
        return this.#endDate;
    }

    setEndDate(endDate) {
        this.#endDate = endDate;
    }

    getLecturer() {
        return this.#lecturer;
    }

    setLecturer(lecturer) {
        this.#lecturer = lecturer;
    }
 
    getLecture() {
        return this.#lecture;
    }

    setLecture(lecture) {
        this.#lecture = lecture;
    }

    getSemester(){
        return this.#semester;
    }

    setSemester(semester){
        this.#semester = semester
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