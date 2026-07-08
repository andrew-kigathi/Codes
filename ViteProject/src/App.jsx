import { Hashrouter, Routes, Route } from "react-router-dom";
import { Home } from "./Pages/Home";
import { About } from "./Pages/About";
import { Layout } from "./Layout";

function App() {
  return(
    <Hashrouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />}/>
          <Route path="about" element={<About />} />
        </Route>
      </Routes>
    </Hashrouter>
  );
}

export default App;