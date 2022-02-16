class Semester {

    #serialVersionUID;
    #id;
    #startDate;
    #endDate;
    #number;
    #name;
    #studyClass;
    #lectureDates;

    getLectureDates(){
        return this.#lectureDates
    }

    addLectureDate(lectureDate){
        this.#lectureDates.push(lectureDate)
    }

    removeLectureDate(lectureDate){
        this.#lectureDates.pop(lectureDate)
    }

    getId(){
        return this.#id;
    }

    setId(id){
        this.#id = id
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

    getNumber() {
        return this.#number
    }

    setNumber(number){
        this.#number = number
    }

    getName() {
        return this.#name
    }

    setName(name) {
        this.#name = name
    }

    equals(Object) {
        //???
        return false;
    }

    hashCode(){
        //???
        return 0;
    }

    toString(){
        //????
    }

    getStudyClass(){
        return this.#studyClass
    }

    setStudyClass(studyClass) {
        this.#studyClass = studyClass
    }



}