import { BrowserRouter, Route, Routes } from "react-router-dom";
import Principal from "./Pages/Principal.jsx";

export default function App(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Principal />} />
            </Routes>  
        </BrowserRouter>
    )
}