import api from "../services/api";

function ExportData() {

  const downloadCollections = async () => {

    try {

      const response =
        await api.get(
          "/export/collections",
          {
            responseType: "blob"
          }
        );

      const url =
        window.URL.createObjectURL(
          new Blob([response.data])
        );

      const link =
        document.createElement("a");

      link.href = url;

      link.setAttribute(
        "download",
        "Collections.xlsx"
      );

      document.body.appendChild(link);

      link.click();

      link.remove();

    } catch (error) {

      console.error(error);

      alert(
        "Export failed"
      );
    }
  };

  const downloadExpenses = async () => {

  try {

    const response =
      await api.get(
        "/export/expenses",
        {
          responseType: "blob"
        }
      );

    const url =
      window.URL.createObjectURL(
        new Blob([response.data])
      );

    const link =
      document.createElement("a");

    link.href = url;

    link.setAttribute(
      "download",
      "Expenses.xlsx"
    );

    document.body.appendChild(link);

    link.click();

    link.remove();

  } catch (error) {

    console.error(error);

    alert(
      "Export failed"
    );
  }
};

  return (

    <div className="container">

      <h2>
        Export Data
      </h2>

      <button
        onClick={downloadCollections}
      >
        Download Collections Excel
      </button>

      <button
        onClick={downloadExpenses}
        >
        Download Expenses Excel
        </button>

    </div>

  );
}

export default ExportData;