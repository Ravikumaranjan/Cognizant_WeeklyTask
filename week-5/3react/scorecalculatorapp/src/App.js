import CalculateScore from "./Components/CalculateScore";

function App() {

    return (
        <div>
            <CalculateScore
                name="Prateek Tripathi"
                school="LPU"
                total={450}
                goal={5}
            />
        </div>
    );
}

export default App;