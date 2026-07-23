import "./../Stylesheets/mystyle.css";

function CalculateScore(props) {

    const average = props.total / props.goal;

    return (
        <div className="container">
            <h2>Student Details</h2>

            <p><strong>Name :</strong> {props.name}</p>

            <p><strong>School :</strong> {props.school}</p>

            <p><strong>Total Marks :</strong> {props.total}</p>

            <p><strong>Subjects :</strong> {props.goal}</p>

            <h3>Average Score : {average}</h3>
        </div>
    );
}

export default CalculateScore;