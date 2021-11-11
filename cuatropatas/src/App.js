import ParticlesBg from "particles-bg";
import Login from "./components/Login";

function App() {
  return (
      <div className="App">
          <ParticlesBg type="cobweb" bg={true}/>
          <Login />
      </div>
  );
}

export default App;
