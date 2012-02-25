var Licks = window.Licks || {};
var Wami = window.Wami;
Licks.isReady = function()
{
}

Licks.setup = function()
{
    Wami.setup(
        {
            id: "wami",
            onReady: Licks.isReady
        });
}

Licks.recordSomething = function()
{
    Wami.startRecording("/");
    alert("recording....");
    Wami.stopRecording();
}
